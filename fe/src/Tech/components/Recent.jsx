import React from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';
import '../css/Recent.css';

import date from '../img/day.png';
import looked from '../img/feather_eye.png';
import liked from '../img/heart.png';

import PostDetails from '../../components/PostDetails';
import Partition from '../../components/Partition';
import Tags from './Tags';

const Recent = function ({ id, title, summary }) {
  return (
    <div className="recent">
      <div className="recent-img" />
      <div className="recent-info">
        <div className="recent-top">
          <span className="recent-title">{title}</span>
          <Tags />
        </div>
        <div className="recent-middle">
          <span>{summary}</span>
        </div>
        <div className="recent-bottom">
          <div className="recent-bottom-left">
            <PostDetails src={date} alt="date" info={id} />
            <Partition />
            <PostDetails src={looked} alt="looked" info={id} />
            <Partition />
            <PostDetails src={liked} alt="liked" info={id} />
          </div>
          <PostDetails
            className="recent-bottom-right"
            src={liked}
            alt="liked"
            info={id}
          />
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
