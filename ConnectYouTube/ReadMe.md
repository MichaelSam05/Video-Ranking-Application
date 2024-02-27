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


## Getting Started

### Dependencies

* 

### Installing

* How/where to download your program
* Any modifications needed to be made to files/folders

### Executing program

* How to run the program
* Step-by-step bullets
```
code blocks for commands
```

## Help

Any advise for common problems or issues.
```
command to run if program contains helper info
```
## Usage/User Stories

#### Functionality
- The first launch of the web application automatically calls the GET method (through the /videos or / endpoints) that returns an Arraylist object of Videos which is interpreted as the leaderboard.
- Adding a thumbnail/image url to the database is serviced through the /add-video endpoint with a body schema from which a POST method recieves the title and image url of the video to be added to the MongoDb database.

- Likewise, deleting an entry/video is done via a DELETE method that recieves the video "id" automatically through the PathVariable Spring Boot annotation.

- Starting a ranked match is done through the /rank endpoint whereby a GET request is called and the REST API responds by randomly selecting a thumbnail from the database and finding another thumbnail that is closest in elo to the first thumbnail. After the user votes, a PUT request to the API is triggered an the participating thumbnail elos are updated; the winning thumbnail gains elo while the losing thumbnail loses elo. (Elo Ranking Details)




## License

This project is licensed under the [NAME HERE] License - see the LICENSE.md file for details

## Contact
Michael Sam - michaelsam2016@outlook.com

## Acknowledgments

* [React Sidebar Tutorial](https://www.youtube.com/watch?v=CXa0f4-dWi4&t=1564s)
* [Spring Boot + MongoDb Tutorial](https://www.youtube.com/watch?v=5PdEmeopJVQ&t=7086s)

* [YouTube API Documentation](https://developers.google.com/youtube/v3)

