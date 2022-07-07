import React, { useRef } from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import '@toast-ui/editor/dist/toastui-editor.css';
import { Editor } from '@toast-ui/react-editor';

import HashtagInput from './HashtagInput';
import TitleInput from './TitleInput';
import CategorySelectBox from './CategorySelectBox';

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
      <CategorySelectBox />
      <TitleInput />
      <HashtagInput />
      <Editor
        ref={editorRef}
        initialValue=""
        placeholder="여기에 내용을 입력하세요.."
        previewStyle="vertical"
        height="80vh"
      />
      <button type="submit" onClick={onSubmit}>
        작성완료
      </button>
    </div>
  );
}

export default Write;
