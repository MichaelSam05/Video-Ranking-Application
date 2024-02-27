import './App.css'
import ListVideos from './components/ListVideos.jsx'
import Sidebar from './components/Sidebar.jsx'
import {BrowserRouter,Routes,Route} from 'react-router-dom'
import VideoComponent from './components/VideoComponent.jsx'
import RankComponenent from './components/RankComponenent.jsx'
function App() {
  

  return (
    <>
      <BrowserRouter>
      <Sidebar/>
      <Routes>
        {/* //http://localhost:3000 */}
        <Route path='/'element = { <ListVideos />} ></Route>
        {/* //http://localhost:3000/videos */}
        <Route path='/videos'element = { <ListVideos />} ></Route>
        {/* //http://localhost:3000/add-video */}
        <Route path='/add-video'element = {<VideoComponent />}></Route>
        {/* //http://localhost:3000/rank */}
        <Route path = '/rank' element = {<RankComponenent/>}></Route>
      </Routes>
      </BrowserRouter>
    </>
  )
}

export default App