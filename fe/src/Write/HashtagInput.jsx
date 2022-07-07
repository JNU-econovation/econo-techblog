import React, { useState } from 'react';

import './css/HashtagInput.css';

const SEPERATOR = ',';
const BACK_SPACE_CODE = 8;

function HashtagInput() {
  const [hashtagList, setHashtagList] = useState([]);
  const [inputState, setInputState] = useState('');

  const handleHashTagList = (content) => {
    const lastChar = content.charAt(content.length - 1);
    if (lastChar === SEPERATOR) {
      if (inputState === '') {
        setInputState(() => '');
      } else if (hashtagList.indexOf(inputState) !== -1) {
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
      if (hashtagList.indexOf(inputState) !== -1) {
        setInputState(() => '');
        return;
      }
      const newList = [...hashtagList, inputState];
      setHashtagList(() => newList);
      setInputState(() => '');
    }
  };

  const onKeyDown = (e) => {
    if (inputState === '') {
      if (e.keyCode === BACK_SPACE_CODE) {
        const newList = hashtagList.splice(0, hashtagList.length - 1);
        setHashtagList(() => newList);
      }
    }
  };

  const onClick = (e) => {
    const newList = hashtagList.filter((hashtag) => hashtag !== e.target.value);
    setHashtagList(() => newList);
  };
  return (
    <div className="hashtag-input-container">
      {hashtagList.map((e) => (
        <button
          type="button"
          onClick={onClick}
          className="hashtag-element"
          value={e}
        >
          {`#${e}`}
        </button>
      ))}
      <input
        className="hashtag-input"
        onChange={onChange}
        onKeyDown={onKeyDown}
        onKeyPress={onKeyPress}
        value={inputState}
        placeholder="태그를 입력하세요..."
      />
    </div>
  );
}

export default HashtagInput;
