import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';
import noImg from '../img/no_img.png';

import '../css/Comment.css';

const Comment = function ({ name, desc }) {
  return (
    <div className="comment">
      <img src={noImg} alt="no-img" />
      <div className="comment-info">
        <span className="comment-writer">{name}</span>
        <span className="comment-desc">{desc}</span>
      </div>
    </div>
  );
};

Comment.propTypes = {
  name: PropTypes.string.isRequired,
  desc: PropTypes.string.isRequired,
};

export default Comment;
