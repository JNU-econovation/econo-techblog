/* eslint-disable react/forbid-prop-types */
import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import './RecentPost.css';

const RecentPost = function ({ post }) {
  return (
    <div className="recent-post">
      <div className="recent-post__img" />
      <div className="recent-post-info">
        <span className="recent-post-title">{post.title}</span>
        <span className="recent-post-desc">{post.content}</span>
        <div className="recent-post-tags">
          {post.categoryName.split(',').map((tag) => (
            <span>{`#${tag}`}</span>
          ))}
        </div>
      </div>
      <div className="recent-post-writer">
        <span className="writer-name">{post.userName}</span>
        <div className="writer-img" />
      </div>
    </div>
  );
};

RecentPost.propTypes = {
  post: PropTypes.object.isRequired,
};

export default RecentPost;
