const main = () => {
  console.log('Hello!');
  console.log("Hello!!");
};

main();

let obj: {
  readonly foo: number;
};

obj = {foo: 1};
obj = {foo: 2};