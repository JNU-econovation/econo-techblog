import React from 'react';
import './css/PostDetails.css';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import bar from './img/select_bar.png';
import dateImg from './img/day.png';
import viewsImg from './img/feather_eye.png';
import heartsImg from './img/heart.png';

const PostDetails = function ({ date, views, hearts }) {
  const formatDate = date.split(' ')[0].replace(/\//gi, '.');
  return (
    <div className="post-details">
      <img src={dateImg} alt="date" className="post-details__img" />
      <span>{formatDate}</span>
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
  views: PropTypes.number.isRequired,
  hearts: PropTypes.number.isRequired,
};

export default PostDetails;
