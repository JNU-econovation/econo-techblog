import React from 'react';
import './css/PostDetails.css';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import bar from './img/select_bar.png';
import dateImg from './img/day.png';
import viewsImg from './img/feather_eye.png';
import heartsImg from './img/heart.png';

const PostDetails = function ({ date, views, hearts }) {
  return (
    <div className="post-details">
      <img src={dateImg} alt="date" className="post-details__img" />
      <span>{date}</span>
      <img src={bar} alt="|" className="post-details__bar" />
      <img src={viewsImg} alt="views" className="post-details__img" />
      <span>{views}</span>
      <img src={bar} alt="|" className="post-details__bar" />
      <img src={heartsImg} alt="hearts" className="post-details__img" />
      <span>{hearts}</span>
    </div>
  );
};

PostDetails.propTypes = {
  date: PropTypes.string.isRequired,
  views: PropTypes.string.isRequired,
  hearts: PropTypes.string.isRequired,
};

export default PostDetails;
