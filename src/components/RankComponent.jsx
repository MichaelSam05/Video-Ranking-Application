import React from 'react'
import { useNavigate } from 'react-router-dom'
import { createRankMatch,updateElos } from '../services/VideoService'
import {useEffect, useState} from 'react'
import './RankComponent.css'




function RankComponenent() {
  const [videos,setVideos] = useState([])
  const [winner, setWinner] = useState('')
  const [losser,setLosser] = useState('')
  const navigator = useNavigate();

  useEffect(() => {
    createRankMatch().then((response) => {
          setVideos(response.data);
      }).catch(error => {
          console.error(error);
      })
 },[])

 function vote(e) {
  if(e.id == videos[1].id) {

    setWinner(e.thumbnail);
    setLosser(videos[0].thumbnail);
  } else {
    setWinner(e.thumbnail);
    setLosser(videos[1].thumbnail);
  }
  const video = {winner, losser}
  updateElos(video).then((response) => {
    console.log(response.data);
    navigator('/videos')
  })

 }

  return (
    
    <div className='rank-container'>
      <h1>Double Click Vote Button To Vote</h1>
      <table className='table table-striped table-bordered'>
    
            <tbody>
                {
                    videos.sort((a,b) => a.elo < b.elo? 1 : -1).map(video =>
                        <tr key={video.id}>
                            <td>{video.videoTitle}</td>
                            <td> <img src={video.thumbnail} width="175" height="100"></img> </td>
                            <td><button type ="button" className="btn btn-primary mb-2" onClick={()=> vote(video)} >Vote</button></td>
                        </tr>)
                }
            </tbody>
        </table>
    </div>
    
  )
}

export default RankComponenent