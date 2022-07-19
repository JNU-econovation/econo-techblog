import React from 'react';
import { Link } from 'react-router-dom';

import './css/LoginLink.css';

function LoginLink() {
  return (
    <div className="login-link__content">
      <Link to="/findid">아이디 찾기</Link>
      <div>|</div>
      <Link to="/findpassword">비밀번호 찾기</Link>
    </div>
  );
}

export default LoginLink;
