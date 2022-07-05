/* eslint-disable operator-linebreak */
/* eslint-disable no-useless-escape */
import React, { useState, useEffect } from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

import './css/EmailStatus.css';

function EmailStatus({ email }) {
  const reg =
    /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
  const [status, setStatus] = useState('');
  const [canVerify, setCanVerify] = useState(false);

  const onClick = () => {
    if (canVerify) {
      // 이메일 인증 로직
      console.log('request verify');
    }
  };

  const verifyEmail = () => {
    if (reg.test(email)) {
      setStatus(() => '올바른 이메일 형식입니다.(인증하기)');
      setCanVerify(() => true);
    } else {
      setStatus(() => '올바른 이메일 형식이 아닙니다.');
      setCanVerify(() => false);
    }
  };
  useEffect(() => {
    if (email === '') {
      setStatus(() => '이메일을 입력해주세요.');
      setCanVerify(() => false);
    } else {
      verifyEmail();
    }
  }, [email]);

  return (
    <button type="button" onClick={onClick} className="email-verify-btn">
      {status}
    </button>
  );
}

EmailStatus.propTypes = {
  email: PropTypes.string.isRequired,
};

export default EmailStatus;
