import React, { useState } from 'react';
import heart from '../img/heart.png';
import clickheart from '../img/clickheart.png';
import '../css/Liked.css';

const Liked = function () {
  const [liked, setLiked] = useState(false);
  const onClick = () => {
    setLiked(!liked);
  };
  return (
    <div className="liked">
      <button
        onClick={onClick}
        className={liked ? 'liked-btn on' : 'liked-btn'}
        type="button"
      >
        <span>좋아요</span>
        {liked ? (
          <img src={clickheart} alt="liked" />
        ) : (
          <img src={heart} alt="liked" />
        )}
      </button>
    </div>
  );
};

export default Liked;
