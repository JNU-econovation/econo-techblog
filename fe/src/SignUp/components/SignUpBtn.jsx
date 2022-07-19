import React from 'react';

import '../css/SignUpBtn.css';

function SignUpBtn() {
  const onClick = () => {
    // 이메일 인증 완료 로직
    // 모두 입력되었는지 검증하는 로직
  };

  return (
    <button className="sign-up__button" type="submit" onClick={onClick}>
      가입하기
    </button>
  );
}

export default SignUpBtn;
