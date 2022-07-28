import React, { useEffect, useState } from 'react';
import './RecentPosts.css';

import RecentPost from './components/RecentPost';

const postsList = [
  {
    id: 1,
    title: '구름톡 업데이트 48시간 전, 그 치열함에',
    desc: '안녕하세요. 우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는 채상아 입니다. 이전 글에서 말씀드렸듯이 Android',
    tags: ['html', 'css'],
    writer: '에코노베이션',
  },
  {
    id: 2,
    title: '구름톡 업데이트 48시간 전, 그 치열함에',
    desc: '안녕하세요. 우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는 채상아 입니다. 이전 글에서 말씀드렸듯이 Android',
    tags: ['html', 'css'],
    writer: '에코노베이션',
  },
  {
    id: 3,
    title: '구름톡 업데이트 48시간 전, 그 치열함에',
    desc: '안녕하세요. 우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는 채상아 입니다. 이전 글에서 말씀드렸듯이 Android',
    tags: ['html', 'css'],
    writer: '에코노베이션',
  },
  {
    id: 4,
    title: '구름톡 업데이트 48시간 전, 그 치열함에',
    desc: '안녕하세요. 우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는 채상아 입니다. 이전 글에서 말씀드렸듯이 Android',
    tags: ['html', 'css'],
    writer: '에코노베이션',
  },
  {
    id: 5,
    title: '구름톡 업데이트 48시간 전, 그 치열함에',
    desc: '안녕하세요. 우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는 채상아 입니다. 이전 글에서 말씀드렸듯이 Android',
    tags: ['html', 'css'],
    writer: '에코노베이션',
  },
  {
    id: 6,
    title: '구름톡 업데이트 48시간 전, 그 치열함에',
    desc: '안녕하세요. 우아한형제들에서 만화경 안드로이드 앱을 개발하고 있는 채상아 입니다. 이전 글에서 말씀드렸듯이 Android',
    tags: ['html', 'css'],
    writer: '에코노베이션',
  },
];

const RecentPosts = function () {
  const [posts, setPosts] = useState([]);
  const getTechPosts = () => {
    setPosts(postsList);
  };
  useEffect(() => {
    getTechPosts();
  }, []);

  const [navArr, setArr] = useState([
    {
      id: 1,
      name: 'Tech',
      active: true,
    },
    {
      id: 2,
      name: 'Culture',
      active: false,
    },
    {
      id: 3,
      name: 'Trouble Shooting',
      active: false,
    },
  ]);
  const onClick = (id) => {
    setArr(
      navArr.map((item) => {
        const elem = item;
        if (elem.id === id) {
          elem.active = true;
        } else {
          elem.active = false;
        }
        return elem;
      }),
    );
  };
  return (
    <div className="recent-posts">
      <h2 className="recent-posts__title">Recent Posts</h2>
      <div className="recent-posts-nav">
        {navArr.map((elem) => (
          <button
            key={elem.id}
            type="button"
            className={
              elem.active
                ? 'recent-posts__nav-item recent-posts__nav-item--active'
                : 'recent-posts__nav-item'
            }
            onClick={() => onClick(elem.id)}
          >
            {elem.name}
          </button>
        ))}
      </div>
      <div className="recent-posts-box">
        {posts.map((item) => (
          <RecentPost
            key={item.id}
            title={item.title}
            desc={item.desc}
            writer={item.writer}
          />
        ))}
      </div>
    </div>
  );
};

export default RecentPosts;
