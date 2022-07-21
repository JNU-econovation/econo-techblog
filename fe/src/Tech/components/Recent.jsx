import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';
import '../css/Recent.css';

import noImg from '../img/no_img.png';

import PostDetails from '../../components/PostDetails';
import Tags from '../../components/Tags';

const Recent = function ({ id, title, summary }) {
  return (
    <div className="recent">
      <div className="recent__img" />
      <div className="recent-info">
        <div className="recent-info-top">
          <span className="recent-info__title">{title}</span>
          <Tags />
        </div>
        <div className="recent-info-middle">
          <span>{summary}</span>
        </div>
        <div className="recent-info-bottom">
          <div className="recent-info-bottom-left">
            <PostDetails date="2022.05.04" views="21" hearts="21" />
          </div>
          <div className="recent-info-bottom-right">
            <span>{id}</span>
            <img
              src={noImg}
              alt="no-img"
              className="recent-info-bottom-right__img"
            />
          </div>
        </div>
      </div>
    </div>
  );
};

Recent.propTypes = {
  id: PropTypes.number.isRequired,
  title: PropTypes.string.isRequired,
  summary: PropTypes.string.isRequired,
};

export default Recent;
