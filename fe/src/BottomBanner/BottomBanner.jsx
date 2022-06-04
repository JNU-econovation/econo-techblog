import React from 'react';
import './BottomBanner.css';
import enoco from './img/econo.png';

const BottomBanner = function () {
  return (
    <div className="bottom-banner">
      <div className="banner-box">
        <img className="banner-img" src={enoco} alt="econo" />
        <div className="banner-text">
          <h2 className="banner-text-h2">ECONOVATION</h2>
          <p className="banner-text-p">
            에코노베이션은 코딩을 하고싶은 누구에게나
            <br />
            즐겁게 그리고 함께 개발하는 공간이 되는 것을 꿈꿉니다.
          </p>
          <button className="banner-btn" type="button">
            웹사이트 바로가기
          </button>
        </div>
      </div>
    </div>
  );
};

export default BottomBanner;
