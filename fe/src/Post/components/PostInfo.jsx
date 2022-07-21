import React, { useState } from 'react';

import '../css/PostInfo.css';
import PostDetails from '../../components/PostDetails';
import SelectBox from './SelectBox';

import noImg from '../img/no_img.png';
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
          <PostDetails date="2022.05.04" views="21" hearts="21" />
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
