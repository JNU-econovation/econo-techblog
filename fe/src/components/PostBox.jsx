import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import './css/PostBox.css';
import Tags from './Tags';
import PostDetails from './PostDetails';
import noImg from './img/no_img.png';

const PostBox = function ({ id, title, summary }) {
  return (
    <div className="post-box">
      <div className="post-box__img" />
      <div className="post-box-info">
        <div className="post-box-info-top">
          <span className="post-box-info__title">{title}</span>
          <Tags />
        </div>
        <div className="post-box-info-middle">
          <span>{summary}</span>
        </div>
        <div className="post-box-info-bottom">
          <div className="post-box-info-details">
            <PostDetails date="2022.05.04" views="21" hearts="21" />
          </div>
          <div className="post-box-info-author">
            <span>{id}</span>
            <img
              src={noImg}
              alt="no-img"
              className="post-box-info-author__img"
            />
          </div>
        </div>
      </div>
    </div>
  );
};

PostBox.propTypes = {
  id: PropTypes.number.isRequired,
  title: PropTypes.string.isRequired,
  summary: PropTypes.string.isRequired,
};

export default PostBox;
