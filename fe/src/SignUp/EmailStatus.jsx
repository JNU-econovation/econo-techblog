/* eslint-disable operator-linebreak */
/* eslint-disable no-useless-escape */
import React, { useState, useEffect } from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import PropTypes from 'prop-types';

function EmailStatus({ email }) {
  const reg =
    /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
  const [status, setStatus] = useState('');

  const verifyEmail = () => {
    if (reg.test(email)) {
      setStatus('올바른 이메일 형식입니다.(인증하기)');
    } else {
      setStatus('올바른 이메일 형식이 아닙니다.');
    }
  };
  useEffect(() => {
    if (email === '') {
      setStatus('이메일을 입력해주세요.');
    } else {
      verifyEmail();
    }
  }, [email]);

  return <span>{status}</span>;
}

EmailStatus.propTypes = {
  email: PropTypes.string.isRequired,
};

export default EmailStatus;
