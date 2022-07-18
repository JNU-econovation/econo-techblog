import React from 'react';
import '../css/Official.css';

import noImg from '../img/no_img.png';
import date from '../img/day.png';
import looked from '../img/feather_eye.png';
import liked from '../img/heart.png';

import PostDetails from '../../components/PostDetails';
import Tags from './Tags';
import Partition from '../../components/Partition';

const result = {
  author: '에코노베이션',
  title: '행복한 에코노베이션',
  desc: '안녕하세요. 우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는 채상아 입니다.이전 글에서 말씀드렸듯이 Android 구름톡을 가지고 돌아왔습니다. 지난 2월, 구름톡 성과를 가지고 전사 발표까지 하게 됐는데요. 정말 영광이었습니다. 발표를 하고 나서 가장 공감받았던 부분은 바로 “정말 힘들었습니다” (한숨) 부분이었습니다. 안녕하세요. 우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는 채상아 입니다.이전 글에서 말씀드렸듯이 Android 구름톡을 가지고 돌아왔습니다. 지난 2월, 구름톡 성과를 가지고 전사 발표까지 하게 됐는데요. 정말 영광이었습니다. 발표를 하고 나서 가장 공감받았던 부분은 바로 “정말 힘들었습니다” (한숨) 부분이었습니다.',
  date: '2021.05.04',
  looked: '21',
  liked: '21',
};

const Official = function () {
  return (
    <div className="official">
      <div className="official__img" />
      <div className="official-info">
        <div className="official-info-top">
          <span className="official-title">{result.title}</span>
          <Tags />
        </div>
        <div className="official-info-middle">
          <span>{result.desc}</span>
        </div>
        <div className="official-info-bottom">
          <div className="official-info-bottom-left">
            <img
              src={noImg}
              alt="no-img"
              className="official-info-bottom-left__img"
            />
            <span className="official-info-bottom-left__span">
              {result.author}
            </span>
          </div>
          <PostDetails src={date} alt="date" info={result.date} />
          <Partition />
          <PostDetails src={looked} alt="looked" info={result.looked} />
          <Partition />
          <PostDetails src={liked} alt="liked" info={result.liked} />
        </div>
      </div>
    </div>
  );
};

export default Official;
