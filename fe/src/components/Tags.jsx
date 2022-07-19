import React from 'react';

import './css/Tags.css';

const result = {
  tags: ['CSS', 'HTML'],
};

const Tags = function () {
  return (
    <div className="tags">
      {result.tags.map((tag) => (
        <span className="tag">{`#${tag}`}</span>
      ))}
    </div>
  );
};

export default Tags;
