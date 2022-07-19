import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';
import '../css/Recent.css';

import noImg from '../img/no_img.png';
import date from '../img/day.png';
import looked from '../img/feather_eye.png';
import liked from '../img/heart.png';

import PostDetails from '../../components/PostDetails';
import Partition from '../../components/Partition';
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
            <PostDetails src={date} alt="date" info={id} />
            <Partition />
            <PostDetails src={looked} alt="looked" info={id} />
            <Partition />
            <PostDetails src={liked} alt="liked" info={id} />
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
