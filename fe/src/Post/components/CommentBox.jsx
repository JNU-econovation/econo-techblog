import React, { useState } from 'react';
import '../css/CommentBox.css';

const CommentBox = function () {
  const [comment, setComment] = useState('');
  const onChange = (e) => {
    setComment(() => e.target.value);
  };
  return (
    <div className="comment-box">
      <div className="writer-img" />
      <div className="comment-box-info">
        <span className="writer">이서현</span>
        <div className="comment-content">
          <textarea className="comment-box-input" onChange={onChange} />
          <button type="button" disabled={!comment}>
            확인
          </button>
        </div>
      </div>
    </div>
  );
};

export default CommentBox;
