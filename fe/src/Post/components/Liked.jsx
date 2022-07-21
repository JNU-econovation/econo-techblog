import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import heart from '../img/heart.png';
import clickheart from '../img/clickheart.png';
import '../css/Liked.css';

const Liked = function ({ liked, setLiked }) {
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
        <span className="liked__span">좋아요</span>
        {liked ? (
          <img src={clickheart} alt="liked" className="liked__img" />
        ) : (
          <img src={heart} alt="liked" className="liked__img" />
        )}
      </button>
    </div>
  );
};

Liked.propTypes = {
  liked: PropTypes.bool.isRequired,
  setLiked: PropTypes.func.isRequired,
};

export default Liked;
