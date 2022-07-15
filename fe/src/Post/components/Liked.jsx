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
        className={liked ? 'liked__button liked__button--on' : 'liked__button'}
        type="button"
      >
        <span className="liked__button__span">좋아요</span>
        {liked ? (
          <img src={clickheart} alt="liked" className="liked__button__img" />
        ) : (
          <img src={heart} alt="liked" className="liked__button__img" />
        )}
      </button>
    </div>
  );
};

export default Liked;
