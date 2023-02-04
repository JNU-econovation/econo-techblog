/* eslint-disable react/no-array-index-key */
/* eslint-disable max-len */
/* eslint-disable react/forbid-prop-types */
import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import './RecentPost.css';
import noImg from '../../components/img/no_img.png';

const RecentPost = function ({ post }) {
  const formatDate = post.createdDate.split(' ')[0].replace(/\//gi, '.');
  return (
    <div className="recent-post">
      <div className="recent-post__img" />
      <div className="recent-post-info">
        <div className="recent-post-title">{post.title}</div>
        <div className="recent-post-middle">
          <span className="recent-post-desc">{post.content}</span>
        </div>
      </div>
      <div className="recent-post-bottom">
        <div className="recent-post-tags">
          {post.categoryName.split(',').map((tag, index) => (
            <span key={index} className="recent-post__tag">{`#${tag}`}</span>
          ))}
        </div>
        <div className="recent-post-writer">
          <div className="recent-post-bottom__info">
            <span className="writer-name">{post.userName}</span>
            <span className="recent-post__date">{formatDate}</span>
          </div>
          <img className="writer-img" src={noImg} alt="user-img" />
        </div>
      </div>
    </div>
  );
};

RecentPost.propTypes = {
  post: PropTypes.object.isRequired,
};

export default RecentPost;
