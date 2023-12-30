import json
import googleapiclient.discovery
import googleapiclient.errors


#Declaration of constants
API_KEY = "AIzaSyAWvFsPMAsoU1c2CPafKOXGH6l0Ot2o43s"
KEYWORD = "coding"
MAX_RESULTS = 10
INDENT = 4

def getVideoIds (youtube):
    request_search_keyword = youtube.search().list(part="snippet",q=KEYWORD,maxResults=MAX_RESULTS,type = "video")
    all_data = []
    response = request_search_keyword.execute()
    for item in response['items']:
        data = item['id']['videoId']
        all_data.append(data)
    return all_data

# Creates and returns a dictionary of all the relevant data from the YouTube api
def getDataTable (youtube,video_ids):
    request_videos = youtube.videos().list(part = "snippet,statistics,contentDetails",id = ','.join(video_ids))
    response = request_videos.execute()
    all_data = []
    count = 0

    for item in response['items']:

        try: # used to avoid videos with missing data in the fields we are interested in
            data = {'VideoTitle': item['snippet']['title'],
                    'Thumbnail': item['snippet']['thumbnails']['default']['url'],
                    'UploadDate': item['snippet']['publishedAt'],
                    'Views': item['statistics']['viewCount'],
                    'VideoID': "https://www.youtube.com/watch?v=" + video_ids[count]}
            count = count + 1
            all_data.append(data)

        except: #removes the unwanted video id from the array of video ids
            data = None
            video_ids.remove(video_ids[count])


    return all_data

def main():

    api_service_name = "youtube"
    api_version = "v3"

    # Get credentials and create an API client
    youtube = googleapiclient.discovery.build(api_service_name, api_version, developerKey=API_KEY)

    videoIDs = getVideoIds (youtube)
    dictionary = getDataTable(youtube,videoIDs)

    print(dictionary)


    # Serializing json
    json_object = json.dumps(dictionary, indent=INDENT)

    # Writing to YTvideos.json
    with open("data/YTvideos.json", "w") as outfile:
        outfile.write(json_object)


if __name__ == "__main__":
    main()

