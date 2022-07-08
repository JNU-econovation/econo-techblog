import React, { useState } from 'react';

import './css/FindInfoBox.css';
import SuccessFindId from './SuccessFindId';

function FindInfoBox() {
  const [name, setName] = useState('');

  return (
    <div className="find-info-box">
      <h3 className="find-info-box-title">아이디 찾기</h3>
      <SuccessFindId />
    </div>
  );
}

export default FindInfoBox;
