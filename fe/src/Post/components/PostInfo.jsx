import React from 'react';
import PostDetails from '../../components/PostDetails';
import Partition from '../../components/Partition';
import '../css/PostInfo.css';

import noImg from '../img/no_img.png';
import date from '../img/day.png';
import looked from '../img/feather_eye.png';
import liked from '../img/heart.png';

const result = {
  author: '에코노베이션',
  date: '2022.05.04',
  looked: '21',
  liked: '21',
};

const PostInfo = function () {
  return (
    <div className="post-info">
      <div className="post-info-author">
        <img src={noImg} alt="no-img" />
        <span>{result.author}</span>
      </div>
      <PostDetails src={date} alt="date" info={result.date} />
      <Partition />
      <PostDetails src={looked} alt="looked" info={result.looked} />
      <Partition />
      <PostDetails src={liked} alt="liked" info={result.liked} />
    </div>
  );
};

export default PostInfo;
