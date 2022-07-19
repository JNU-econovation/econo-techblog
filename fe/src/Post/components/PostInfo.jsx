import React, { useState } from 'react';

import '../css/PostInfo.css';
import PostDetails from '../../components/PostDetails';
import Partition from '../../components/Partition';
import SelectBox from './SelectBox';

import noImg from '../img/no_img.png';
import date from '../img/day.png';
import looked from '../img/feather_eye.png';
import liked from '../img/heart.png';
import more from '../img/post_more.png';

const result = {
  author: '에코노베이션',
  date: '2022.05.04',
  looked: '21',
  liked: '21',
};

const PostInfo = function () {
  const [isOpen, setOpen] = useState(false);
  const onClick = () => {
    setOpen(!isOpen);
  };
  return (
    <div className="post-info">
      <div className="post-info__content">
        <div className="post-info-left">
          <div className="post-info-author">
            <img src={noImg} alt="no-img" className="post-info-author__img" />
            <span>{result.author}</span>
          </div>
          <PostDetails src={date} alt="date" info={result.date} />
          <Partition />
          <PostDetails src={looked} alt="looked" info={result.looked} />
          <Partition />
          <PostDetails src={liked} alt="liked" info={result.liked} />
        </div>
        <button type="button" className="post-info__button" onClick={onClick}>
          <img src={more} alt="more" className="post-info__img" />
        </button>
      </div>
      {isOpen && <SelectBox />}
    </div>
  );
};

export default PostInfo;
