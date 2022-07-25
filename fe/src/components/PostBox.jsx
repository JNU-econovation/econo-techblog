import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import './css/PostBox.css';
import Tags from './Tags';
import PostDetails from './PostDetails';
import noImg from './img/no_img.png';

const PostBox = function ({ post }) {
  return (
    <div className="post-box">
      <div className="post-box__img" />
      <div className="post-box-info">
        <div className="post-box-info-top">
          <span className="post-box-info__title">{post.title}</span>
          <Tags tags={post.categoryName} />
        </div>
        <div className="post-box-info-middle">
          <span className="post-box-info__content">{post.content}</span>
        </div>
        <div className="post-box-info-bottom">
          <div className="post-box-info-details">
            <PostDetails
              date={post.createdDate}
              views={post.views}
              hearts={post.hearts}
            />
          </div>
          <div className="post-box-info-author">
            <span>{post.userName}</span>
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
  // eslint-disable-next-line react/forbid-prop-types
  post: PropTypes.object.isRequired,
};

export default PostBox;
