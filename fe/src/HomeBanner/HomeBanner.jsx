import React from 'react';

import './HomeBanner.css';
import facebook from './img/facebook.png';
import insta from './img/insta.png';
import youtube from './img/youtube.png';
import blog from './img/blog.png';

function HomeBanner() {
  return (
    <div className="home-banner">
      <div className="home-banner-side__text">econovation tech blog</div>
      <div className="home-banner-text">
        <h1>T-ECONO</h1>
        <p>
          에코노베이션 기술 블로그 T-econo입니다. 문제 해결, 에코노베이션의 행사
          등 에코노 베이션의 다양한 소식을 접할 수 있습니다.
        </p>
      </div>
      <div className="home-banner-button__container">
        <a
          className="home-banner__link"
          href="https://www.instagram.com/cnu_econovation/"
        >
          <img src={insta} alt="banner button" />
        </a>
        <a
          className="home-banner__link"
          href="https://www.facebook.com/econo.jnu.ac.kr/"
        >
          <img src={facebook} alt="banner button" />
        </a>
        <a className="home-banner__link" href="https://medium.com/econovation">
          <img src={blog} alt="banner button" />
        </a>
        <a
          className="home-banner__link"
          href="https://www.youtube.com/channel/UCepdmgc4w5EQIc1J0lqXVtA"
        >
          <img src={youtube} alt="banner button" />
        </a>
      </div>
    </div>
  );
}

export default HomeBanner;
