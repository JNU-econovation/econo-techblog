import React from 'react';
import './BottomBanner.css';
import enoco from './img/econo.png';
import econoGo from './img/econo_go.png';

const BottomBanner = function () {
  return (
    <div className="bottom-banner">
      <div className="bottom-banner-box">
        <img className="bottom-banner__img" src={enoco} alt="econo" />
        <div className="bottom-banner__text">
          <span className="bottom-banner__big-text">ECONOVATION</span>
          <span className="bottom-banner__small-text">
            에코노베이션은 코딩을 하고싶은 누구에게나 즐겁게
            <br />
            그리고 함께 개발하는 공간이 되는 것을 꿈꿉니다.
          </span>
          <button className="bottom-banner-btn" type="button">
            <span>웹사이트 바로가기</span>
            <img
              src={econoGo}
              alt="econo-go"
              className="bottom-banner-btn__img"
            />
          </button>
        </div>
      </div>
    </div>
  );
};

export default BottomBanner;
