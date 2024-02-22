import React, {useEffect, useState} from 'react'
import { createRankMatch, deleteVideo, listVideos } from '../services/VideoService'
import logo from '../images/redheart.png'
import { useNavigate } from 'react-router-dom'
import './ListVideos.css'

function ListVideos() {
    const [videos,setVideos] = useState([])

    const navigator = useNavigate();
    
    useEffect(() => {
        getAllVideos()
    }, [])

    function getAllVideos() {
        listVideos().then((response) => {
            setVideos(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    function removeVideo(id) {
        deleteVideo(id).then((resposne) => {
            getAllVideos();
        }).catch(error => {
            console.error(error);
        })
    }
    
  return (
    <div className='list-container'>
        <h2 className='text-center'>Leaderboard</h2>
        <table className='table table-striped table-bordered'>
            <thead className="table-dark">
               <tr> 

                <th>VideoTitle</th>
                <th>Thumbnail</th>
                <th>Rank</th> 
                <th>VideoUrl</th>
                <th>Action</th>
                </tr> 
            </thead>
            <tbody>
                {
                    videos.sort((a,b) => a.elo < b.elo? 1 : -1).map(video =>
                        <tr key={video.id}>
                            <td>{video.videoTitle}</td>
                            <td> <img src={video.thumbnail} width="175" height="100"></img> </td>
                            <td className="table-warning">{video.elo}</td>
                            <td>{video.videoUrl}</td>
                            <td><button  type="button" className="btn btn-danger"  onClick={()=> removeVideo(video.id)}>Delete</button></td>
                        </tr>)
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListVideos