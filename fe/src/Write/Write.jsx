import React, { useRef } from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import '@toast-ui/editor/dist/toastui-editor.css';
import { Editor } from '@toast-ui/react-editor';

import HashtagInput from './HashtagInput';

function Write() {
  const editorRef = useRef();

  const onSubmit = () => {
    const contentHTML = editorRef.current?.getInstance().getHTML();
    const contentMarkdown = editorRef.current?.getInstance().getMarkdown();
    console.log('contentHTML', contentHTML);
    console.log('contentMarkdown', contentMarkdown);
  };
  return (
    <div className="write">
      <HashtagInput />
      <Editor ref={editorRef} initialValue="여기에 내용을 입력하세요.." />
      <button type="submit" onClick={onSubmit}>
        제출하기
      </button>
    </div>
  );
}

export default Write;
