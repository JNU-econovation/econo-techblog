import React from 'react';
import '../css/PostInfo.css';

import day from '../img/day.png';
import featherEye from '../img/feather_eye.png';
import heart from '../img/heart.png';

const result = {
  author: '에코노베이션',
  day: '2022.05.04',
  looked: '21',
  liked: '21',
};

const PostInfo = function () {
  return (
    <div className="post-info">
      <div className="spec-info">
        <div className="writer-img" />
        <span>{result.author}</span>
      </div>
      <div className="spec-info">
        <img src={day} alt="day" />
        <span>{result.day}</span>
      </div>
      <span className="info-divider">|</span>
      <div className="spec-info">
        <img src={featherEye} alt="looked" />
        <span>{result.looked}</span>
      </div>
      <span className="info-divider">|</span>
      <div className="spec-info">
        <img src={heart} alt="liked" />
        <span>{result.liked}</span>
      </div>
    </div>
  );
};

export default PostInfo;
