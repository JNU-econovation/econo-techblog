import React, { useRef } from 'react';
// eslint-disable-next-line import/no-extraneous-dependencies
import '@toast-ui/editor/dist/toastui-editor.css';
import { Editor } from '@toast-ui/react-editor';

import HashtagInput from './HashtagInput';
import TitleInput from './TitleInput';
import CategorySelectBox from './CategorySelectBox';
import './css/Write.css';

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
      <h3 className="write-title">게시판 글쓰기</h3>
      <div className="write__grid">
        <div className="write-category__title">게시판</div>
        <CategorySelectBox />
        <div className="write-category__title">제목</div>
        <TitleInput />
        <div className="write-category__title">태그</div>
        <HashtagInput />
        <div className="write-category__title">본문</div>
        <div className="write-editor">
          <Editor
            ref={editorRef}
            initialValue=" "
            placeholder="여기에 내용을 입력하세요.."
            previewStyle="vertical"
            height="100%"
          />
        </div>
      </div>
      <button className="write-cancel__button" type="button">
        취소
      </button>
      <button className="write-submit__button" type="submit" onClick={onSubmit}>
        작성완료
      </button>
    </div>
  );
}

export default Write;
