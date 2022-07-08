import React, { useEffect, useState } from 'react';

import checkCircle from './img/check_circle.png';
import './css/SuccessFindId.css';

const dummyData = {
  name: '이윤성',
  email: 'dbsdltjd123@gmail.com',
};

function SuccessFindId() {
  const [email, setEmail] = useState('');
  const filterId = (id) => {
    setEmail(() => id.replace(id.substr(0, 3), '***'));
  };
  // 첫 요청시에만
  useEffect(() => {
    filterId(dummyData.email);
  }, []);
  return (
    <div className="success-find-id">
      <img className="check-circle" alt="check" src={checkCircle} />
      <div className="name-container">
        <span className="user-name">{dummyData.name}</span>
        님의 ID는
      </div>
      <div className="email-container">{email}</div>
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
