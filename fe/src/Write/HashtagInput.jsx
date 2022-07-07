import React, { useState } from 'react';

import './css/HashtagInput.css';

const SEPERATOR = ',';

function HashtagInput() {
  const [hashtagList, setHashtagList] = useState([]);
  const [inputState, setInputState] = useState('');

  const handleHashTagList = (content) => {
    const lastChar = content.charAt(content.length - 1);
    if (lastChar === SEPERATOR) {
      if (inputState === '') {
        setInputState(() => '');
      } else {
        const newList = [...hashtagList, content.substr(0, content.length - 1)];
        setHashtagList(() => newList);
        setInputState(() => '');
      }
    }
  };

  const onChange = (e) => {
    setInputState(() => e.target.value);
    handleHashTagList(e.target.value);
  };

  const onKeyPress = (e) => {
    if (e.key === 'Enter') {
      if (inputState === '') return;
      const newList = [...hashtagList, inputState];
      setHashtagList(() => newList);
      setInputState(() => '');
    }
  };

  const onKeyDown = (e) => {
    if (inputState === '') {
      if (e.keyCode === 8) {
        const newList = hashtagList.splice(0, hashtagList.length - 1);
        setHashtagList(() => newList);
      }
    }
  };
  return (
    <div className="hashtag-input-container">
      {hashtagList.map((e) => (
        <div className="hashtag-element">{`#${e}`}</div>
      ))}
      <input
        onChange={onChange}
        onKeyDown={onKeyDown}
        onKeyPress={onKeyPress}
        value={inputState}
      />
    </div>
  );
}

export default HashtagInput;
