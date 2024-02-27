import axios from "axios"
const REST_API_BASE_URL = 'http://localhost:8080/api/videos';
export const listVideos = () => axios.get(REST_API_BASE_URL);
export const addNewVideo = (video) => axios.post(REST_API_BASE_URL,video);
export const deleteVideo = (id) => axios.delete(REST_API_BASE_URL + '/' + id);
export const createRankMatch = () => axios.get(REST_API_BASE_URL + "/rank");
export const updateElos = (video) => axios.put(REST_API_BASE_URL,video);