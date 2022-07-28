import React, { useRef } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { Editor } from '@toast-ui/react-editor';
// eslint-disable-next-line import/no-extraneous-dependencies
import '@toast-ui/editor/dist/toastui-editor.css';

import HashtagInput from './HashtagInput';
import TitleInput from './TitleInput';
import CategorySelectBox from './CategorySelectBox';
import './css/Write.css';

function Write() {
  const editorRef = useRef();
  const navigate = useNavigate();
  const onSubmit = () => {
    const contentHTML = editorRef.current?.getInstance().getHTML();
    const contentMarkdown = editorRef.current?.getInstance().getMarkdown();
    console.log('contentHTML', contentHTML);
    console.log('contentMarkdown', contentMarkdown);
  };

  const onCancelClick = () => {
    navigate(-1);
  };

  // 로그인 로직 완료시 주석 해제
  // if (sessionStorage.getItem('uid') === null) {
  //   return <Navigate to="/login" />;
  // }

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
            hooks={{
              addImageBlobHook: async (blob, callback) => {
                console.log(blob);
                // 1. 첨부된 이미지 파일을 서버로 전송후, 이미지 경로 url을 받아온다.
                // const imgUrl = await .... 서버 전송 / 경로 수신 코드 ...
                axios({
                  method: 'post',
                  url: '/api/file/',
                }).then((response) => {
                  console.log(response);
                  callback('http://localhost:3000/img/카레유.png', '카레유'); // image URL, text는 alt
                });
                // 2. 첨부된 이미지를 화면에 표시(경로는 임의로 넣었다.)
              },
            }}
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
