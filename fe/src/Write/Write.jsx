import React, { useRef } from 'react';
import { Navigate, useNavigate } from 'react-router-dom';
import { Editor } from '@toast-ui/react-editor';
// eslint-disable-next-line import/no-extraneous-dependencies
import '@toast-ui/editor/dist/toastui-editor.css';

import HashtagInput from './HashtagInput';
import TitleInput from './TitleInput';
import CategorySelectBox from './CategorySelectBox';
import './css/Write.css';
import { useLoginStateContext } from '../Context/LoginContext';

function Write() {
  const editorRef = useRef();
  const navigate = useNavigate();
  const loginContext = useLoginStateContext();
  const onSubmit = () => {
    const contentHTML = editorRef.current?.getInstance().getHTML();
    const contentMarkdown = editorRef.current?.getInstance().getMarkdown();
    console.log('contentHTML', contentHTML);
    console.log('contentMarkdown', contentMarkdown);
  };

  const onCancelClick = () => {
    navigate(-1);
  };

  if (loginContext.id === -1) {
    return <Navigate to="/login" />;
  }

  return (
    <div className="write">
      <h3 className="write-title">게시판 글쓰기</h3>
      <div className="write__grid">
        <div className="write-item">
          게시판
          <span>*</span>
        </div>
        <div className="write-item__select">
          <CategorySelectBox />
        </div>
        <div className="write-item">
          제목
          <span>*</span>
        </div>
        <div className="write-item__input">
          <TitleInput />
        </div>
        <div className="write-item">
          태그
          <span>*</span>
        </div>
        <div className="write-item__input">
          <HashtagInput />
        </div>
        <div className="write-item">
          본문
          <span>*</span>
        </div>
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
      <div className="write-button__container">
        <button
          className="write-cancel__button"
          type="button"
          onClick={onCancelClick}
        >
          취소
        </button>
        <button
          className="write-submit__button"
          type="submit"
          onClick={onSubmit}
        >
          작성완료
        </button>
      </div>
    </div>
  );
}

export default Write;
