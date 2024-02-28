# Video Ranking Application

Full stack web application written in Java that utilizes a custom REST API architecture to perform and fullfill user requests.

## Project Description

Thumbnails on the video sharing platform, YouTube, play a critical role in determining the success of any given video; a good thumbnail increases the likelyhood of viewers clicking on that video but how can we know if our thumbnail is good enough? Is there a way to pilot something this crucial? This is what my application aims to solve. Content creators can upload their thumbnails to this application where they are pitted against each other in 1vs1 ranked matches to determine which thumbnail is more superior. Though this, content creators can make adjustmenst or gain insight into which thumbnails work to give themselves the best possible chance on the YouTube platform.

## Technologies Used
#### Frontend
- React + Vite 
#### Backend
- Java
- Python
- Spring Boot
#### Database
- MongoDb

## Usage/User Stories

#### Functionality
- The initial dummy data was provided by the YouTube API and can be viewed in [FormattedVideos.json](https://github.com/MichaelSam05/Video-Ranking-Application/blob/master/data/FormattedVideos.json). The code used to interface with the YouTube API can be viewed [here](https://github.com/MichaelSam05/Video-Ranking-Application/blob/master/ConnectYouTube/YTdata.py). I connected to the YouTube API in Python due to its ease of use and through this, I formatted the YouTube's API response (in the form of a json file) to fit the needs of this project.


- On first launch of the web application (via the `/` or `/videos` endpoints) automatically calls the `GET` request method located in the backend where the REST API's response is an Arraylist object of Video objects which is interpreted as the leaderboard.
![leaderboard](../src/assets/Home-Leaderboard.png)


- Adding a thumbnail/image url to the database is serviced through the `/add-video` endpoint with a body schema from which a `POST` request is made to the REST API which is acompanied by the title and image url of the video to be added to the MongoDb database.
![add-component](../src/assets/Add-option.png)

- Likewise, deleting an entry/video is done via a `DELETE` request that recieves the video `id` automatically through the PathVariable Spring Boot annotation.

- Starting a ranked match is done through the `/rank` endpoint whereby a `GET` request is made and the REST API responds by randomly selecting a thumbnail from the database and finding another thumbnail that is closest in elo to the first thumbnail. After the user votes, a `PUT` request to the API is triggered an the participating thumbnail elos are updated; the winning thumbnail gains elo while the losing thumbnail loses elo. The Java code can be found [here](https://github.com/MichaelSam05/Video-Ranking-Application/blob/master/src/main/java/com/VideoRankingApplication/videos/VideoRankingSystem.java) and details about elo calculations can viewed [here](https://www.omnicalculator.com/sports/elo).

![rank-component](../src/assets/rank-component.png)

> All `REST API` requests can be viewed in this [Java class](https://github.com/MichaelSam05/Video-Ranking-Application/blob/master/src/main/java/com/VideoRankingApplication/videos/VideoController.java).

##
## License

This project is licensed under the [NAME HERE] License - see the LICENSE.md file for details

## Contact
Michael Sam - michaelsam2016@outlook.com

## Acknowledgments

* [React Sidebar Tutorial](https://www.youtube.com/watch?v=CXa0f4-dWi4&t=1564s)

* [YouTube API Documentation](https://developers.google.com/youtube/v3)

