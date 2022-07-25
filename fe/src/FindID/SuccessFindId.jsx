/* eslint-disable react/prop-types */
import React, { useEffect, useState } from 'react';

import checkCircle from './img/check_circle.png';
import './css/SuccessFindId.css';

function SuccessFindId({ email, name }) {
  const [userEmail, setUserEmail] = useState('');

  const filterId = (id) => {
    setUserEmail(() => id.replace(id.substr(0, 3), '***'));
  };
  useEffect(() => {
    filterId(email);
  }, []);
  return (
    <div className="success-find-id">
      <img className="check-circle" alt="check" src={checkCircle} />
      <div className="name-container">
        <span className="user-name">{name}</span>
        님의 ID는
      </div>
      <div className="email-container">{userEmail}</div>
      <p>
        개인정보 도용에 대한 피해방지를 위하여
        <br />
        아이디 앞 세자리는 **처리합니다.
      </p>
      <div className="sfi-btn-container">
        <button className="find-password-link-btn" type="button">
          비밀번호 찾기
        </button>
        <button className="login-link-btn" type="button">
          로그인
        </button>
      </div>
    </div>
  );
}

export default SuccessFindId;
