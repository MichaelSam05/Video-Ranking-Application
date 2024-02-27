import React, {useState} from 'react'
import  { addNewVideo }  from '../services/VideoService';
import { useNavigate } from 'react-router-dom';
import "./VideoComponent.css"

function VideoComponent () {
    const [videoTitle, setVideoTitle] = useState('')
    const [videoThumbnail,setThumbnail] = useState('')

    const navigator=useNavigate();

    function handleVideoTitle(e){
        setVideoTitle(e.target.value);
    }

    function handleVideoThumbnail(e){
        setThumbnail(e.target.value);
    }

    function submitForm(e) {
        e.preventDefault();
        const video = {videoTitle, videoThumbnail}
        console.log(video)
        addNewVideo(video).then((response) => {
            console.log(response.data);
            navigator('/videos')
        })
    }

  return (
    <div className = 'container'>
        <br></br>
        <div className= 'row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                <h2 className='text-center'>Add New Video</h2>
                <div className='class-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'><b>Video Title</b></label>
                            <input
                            type='text'
                            placeholder='Enter Video Title'
                            value={videoTitle}
                            className='form-control'
                            onChange={handleVideoTitle}>

                            </input>
                        </div>

                        <div className='form-group mb-2'>
                            <label className='form-label'><b>Thumbnail Url</b></label>
                            <input
                            type='text'
                            placeholder='Enter Thumbnail Url'
                            value={videoThumbnail}
                            className='form-control'
                            onChange={handleVideoThumbnail}>

                            </input>
                        </div>
                        <button className="btn btn-success mb-2" onClick={submitForm}>Submit</button>
                    </form>
                </div>
            </div>
        </div>

    </div>
  )
}
export default VideoComponent