import React from 'react'
import * as AiIcons from "react-icons/ai"
import * as IoIcons from "react-icons/io"
import { LuSwords } from "react-icons/lu";

export const SidebarData =  [
    {
        title: 'Home',
        path: '/videos',
        icon: <AiIcons.AiFillHome/>,
        cName:'nav-text'
    },
    {
        title: 'Add',
        path: '/add-video',
        icon: <IoIcons.IoIosAddCircle/>,
        cName:'nav-text'
    },
    {
        title: 'Rank',
        path: '/rank',
        icon: <LuSwords/>,
        cName:'nav-text'
    },
]