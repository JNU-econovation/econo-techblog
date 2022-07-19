import React from 'react';
import { useNavigate } from 'react-router-dom';

import './css/LoginBtn.css';

function LoginBtn() {
  const navigate = useNavigate();
  // login 완료시 이동하는 로직
  const onClick = () => {
    navigate('/');
  };

  return (
    <button className="login__button" type="submit" onClick={onClick}>
      로그인
    </button>
  );
}

export default LoginBtn;
