import React, { useState } from 'react';
import '../css/CommentBox.css';
import noImg from '../img/no_img.png';

const CommentBox = function () {
  const [comment, setComment] = useState('');
  const onChange = (e) => {
    setComment(() => e.target.value);
  };
  return (
    <div className="comment-box">
      <img src={noImg} alt="no-img" className="comment-box__img" />
      <div className="comment-box__info">
        <span className="comment-box__writer">이서현</span>
        <div className="comment-box__content">
          <textarea className="comment-box__input" onChange={onChange} />
          <button
            type="button"
            disabled={!comment}
            className="comment-box__button"
          >
            확인
          </button>
        </div>
      </div>
    </div>
  );
};

export default CommentBox;
