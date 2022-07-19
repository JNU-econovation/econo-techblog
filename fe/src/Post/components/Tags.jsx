import React from 'react';

import '../css/Tags.css';

const result = {
  tags: ['CSS', 'HTML', 'Javascript'],
};

const Tags = function () {
  return (
    <div className="tags">
      {result.tags.map((tag) => (
        <span className="tags__tag">{`#${tag}`}</span>
      ))}
    </div>
  );
};

export default Tags;
