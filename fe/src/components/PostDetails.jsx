import React from 'react';
import './css/PostDetails.css';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

const PostDetails = function ({ src, alt, info }) {
  return (
    <div className="post-details">
      <img src={src} alt={alt} className="post-details__img" />
      <span>{info}</span>
    </div>
  );
};

PostDetails.propTypes = {
  src: PropTypes.string.isRequired,
  alt: PropTypes.string.isRequired,
  info: PropTypes.string.isRequired,
};

export default PostDetails;
