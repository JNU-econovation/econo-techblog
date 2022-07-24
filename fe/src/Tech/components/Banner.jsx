import React from 'react';
import '../css/Banner.css';

const Banner = function () {
  return (
    <div className="banner">
      <div className="banner-text">
        <h2>Econo Tech</h2>
        <p>
          에코노베이션 정보전달 웹사이트 T-ECONO입니다.
          <br />
          기술적인 부분부터 문제 해결, 에코노베이션의 행사 등 에코노베이션에
          대해 알 수 있습니다.
        </p>
      </div>
    </div>
  );
};

export default Banner;
