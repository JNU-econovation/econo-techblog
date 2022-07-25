import React, { useState } from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';
/* eslint-disable object-curly-newline */

import '../css/PostInfo.css';
import PostDetails from '../../components/PostDetails';
import SelectBox from './SelectBox';

import noImg from '../img/no_img.png';
import more from '../img/post_more.png';

const PostInfo = function ({ author, date, views, hearts, onDelete }) {
  const [isOpen, setOpen] = useState(false);
  const onClick = () => {
    setOpen(!isOpen);
  };
  return (
    <div className="post-info">
      <div className="post-info__content">
        <div className="post-info-left">
          <div className="post-info-author">
            <img src={noImg} alt="no-img" className="post-info-author__img" />
            <span>{author}</span>
          </div>
          <PostDetails date={date} views={views} hearts={hearts} />
        </div>
        <button type="button" className="post-info__button" onClick={onClick}>
          <img src={more} alt="more" className="post-info__img" />
        </button>
      </div>
      {isOpen && <SelectBox onDelete={onDelete} />}
    </div>
  );
};

PostInfo.propTypes = {
  author: PropTypes.string.isRequired,
  date: PropTypes.string.isRequired,
  views: PropTypes.number.isRequired,
  hearts: PropTypes.number.isRequired,
  onDelete: PropTypes.func.isRequired,
};

export default PostInfo;
